/*
 * dht22.c
 *
 *  Created on: May 23, 2015
 *      Author: Marco
 *
 *  Compile:
 *  	 gcc -lwiringPi -o dht22 dht22.c
 */

#include <wiringPi.h>

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <sys/types.h>
#include <unistd.h>
#include <time.h>

#define MAX_TIMINGS 85

static int dht22Pin = 27;
static int dht22Data[5] = { 0, 0, 0, 0, 0 };

static uint8_t sizecvt(const int read) {
	/* digitalRead() and friends from wiringpi are defined as returning a value
	 < 256. However, they are returned as int() types. This is a safety function */

	if (read > 255 || read < 0) {
		printf("Invalid data from wiringPi library\n");
		exit(EXIT_FAILURE);
	}
	return (uint8_t) read;
}

static int readData() {
	uint8_t laststate = HIGH;
	uint8_t counter = 0;
	uint8_t j = 0, i;

	dht22Data[0] = dht22Data[1] = dht22Data[2] = dht22Data[3] = dht22Data[4] = 0;

	// pull pin down for 18 milliseconds
	pinMode(dht22Pin, OUTPUT);
	digitalWrite(dht22Pin, HIGH);
	delay(10);
	digitalWrite(dht22Pin, LOW);
	delay(18);
	// then pull it up for 40 microseconds
	digitalWrite(dht22Pin, HIGH);
	delayMicroseconds(40);
	// prepare to read the pin
	pinMode(dht22Pin, INPUT);

	// detect change and read data
	for (i = 0; i < MAX_TIMINGS; i++) {
		counter = 0;
		while (sizecvt(digitalRead(dht22Pin)) == laststate) {
			counter++;
			delayMicroseconds(1);
			if (counter == 255) {
				break;
			}
		}
		laststate = sizecvt(digitalRead(dht22Pin));

		if (counter == 255)
			break;

		// ignore first 3 transitions
		if ((i >= 4) && (i % 2 == 0)) {
			// shove each bit into the storage bytes
			dht22Data[j / 8] <<= 1;
			if (counter > 16)
				dht22Data[j / 8] |= 1;
			j++;
		}
	}

	// check we read 40 bits (8bit x 5 ) + verify checksum in the last byte
	// print it out if data is good
	if ((j >= 40) && (dht22Data[4] == ((dht22Data[0] + dht22Data[1] + dht22Data[2] + dht22Data[3]) & 0xFF))) {
		float t, h;
		h = (float) dht22Data[0] * 256 + (float) dht22Data[1];
		h /= 10;
		t = (float) (dht22Data[2] & 0x7F) * 256 + (float) dht22Data[3];
		t /= 10.0;

		if ((dht22Data[2] & 0x80) != 0) {
			t *= -1;
		}

		time_t ts = time(NULL);

		printf("<dht22><humidity>%.2f</humidity><temperature>%.2f</temperature><timestamp>%ld</timestamp></dht22>\n", h, t, ts);
		return 1;
	} else {
		return 0;
	}
}

int main(int argc, char *argv[]) {
	if (argc != 2) {
		printf("Usage: %s <pin>\nDescription: pin is the wiringPi pin number\n", argv[0]);
	} else {
		dht22Pin = atoi(argv[1]);

		if (wiringPiSetup() == -1) {
			exit(EXIT_FAILURE);
		}

		while (readData() == 0) {
			// wait 1sec to refresh
			delay(1000);
		}
	}

	return 0;
}
