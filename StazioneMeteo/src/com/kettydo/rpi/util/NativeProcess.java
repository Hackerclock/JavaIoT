package com.kettydo.rpi.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Permette l'esecuzione di un processo nativo.
 * 
 * @see java.lang.ProcessBuilder
 * @see java.lang.Process
 * @author Marco
 * 
 */
public class NativeProcess {

	private static Log log = LogFactory.getLog(NativeProcess.class);

	private ProcessBuilder builder;

	private Process process;

	private List<String> command;

	private Map<String, String> environment;

	private String workingDirectory;

	private Boolean redirectErrorStream;

	private BufferedReader stdIn;

	private BufferedWriter stdOut;

	private BufferedReader stdErr;

	/**
	 * 
	 * @param command
	 *           l'eseguibile esterno e i suoi parametri
	 * @param environment
	 *           contiene le variabili di sistema (PATH, etc). Se non specificato
	 *           assume il valore di System.getenv()
	 * @param workingDirectory
	 *           working direcotory del processo. Se non specificato assume il
	 *           valore della property di sistema user.dir
	 * @param redirectErrorStream
	 *           indica se lo stream di errore del processo deve essere
	 *           ridirezionato sullo stream di output dello stesso. In questo
	 *           caso stdout e stderr sono accessibili mediante
	 *           Process.getInputStream(). Utile nel caso si voglia correlare più
	 *           semplicemente i messaggi di errore con l'output corrispondente
	 * @throws NativeProcessException
	 */
	public NativeProcess(List<String> command, Map<String, String> environment, String workingDirectory, Boolean redirectErrorStream) throws NativeProcessException {
		this.command = command;
		this.environment = environment;
		this.workingDirectory = workingDirectory;
		this.redirectErrorStream = redirectErrorStream;

		initProcessBuilder();
	}

	private void initProcessBuilder() throws NativeProcessException {

		log.debug("Init NativeProcess...");

		builder = new ProcessBuilder(command);
		Map<String, String> env = builder.environment();

		if (environment != null) {
			Set<String> keys = env.keySet();
			for (Iterator<String> i = keys.iterator(); i.hasNext();) {
				String key = i.next();
				String value = environment.get(key);
				env.put(key, value);
			}
		}

		if (workingDirectory != null && !workingDirectory.trim().equals("")) {
			builder.directory(new File(workingDirectory));
		} else {
			builder.directory(new File(System.getProperty("user.home")));
		}

		if (redirectErrorStream != null) {
			builder.redirectErrorStream(redirectErrorStream.booleanValue());
		} else {
			builder.redirectErrorStream(false);
		}

		try {
			process = builder.start();

			stdIn = new BufferedReader(new InputStreamReader(process.getInputStream()));
			stdOut = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			stdErr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		} catch (Exception e) {
			log.error(e, e);
			throw new NativeProcessException(e);
		}

		log.debug("Init NativeProcess done.");
	}

	/**
	 * Esegue il processo e rende disponibili gli stream: stdout (scrive nello
	 * stdin del processo), stdin (legge dallo stdout del processo), stderr
	 * (lagge dallo stderr del processo). Il thread chiamante è bloccato
	 * finch&egrave; il processo termina. Per convenzione il valore di ritorno 0
	 * indica che &egrave; terminato normalmente.
	 * 
	 * @return
	 * @throws NativeProcessException
	 */
	public int run() throws NativeProcessException {
		int res = -1;

		try {
			res = process.waitFor();
		} catch (Exception e) {
			log.error(e, e);
			throw new NativeProcessException(e);
		}

		return (res);
	}

	/**
	 * Termina il processo.
	 * 
	 * @throws NativeProcessException
	 */
	public void kill() throws NativeProcessException {
		try {
			process.destroy();
		} catch (Exception e) {
			log.error(e, e);
			throw new NativeProcessException(e);
		}
	}

	public BufferedReader getStdErr() {
		return stdErr;
	}

	public BufferedReader getStdIn() {
		return stdIn;
	}

	public BufferedWriter getStdOut() {
		return stdOut;
	}

}
