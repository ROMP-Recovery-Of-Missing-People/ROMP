package model;

public class DNArecord {
	private String name1;
	private String file_path;
	private int number1;
	private int id;
	private String details;
	private double match;

	/*
	 * For relatives
	 */
	public DNArecord(int id, String name, int number, String filepath, String details) {
		this.name1 = name;
		this.number1 = number;
		file_path = filepath;
		this.id = id;
		this.details = details;
	}
	/*
	 * For relatives insert
	 */
	public DNArecord(String name, int number, String filepath, String details) {
		this.name1 = name;
		this.number1 = number;
		file_path = filepath;
		this.details = details;
	}

	public DNArecord(String name, int number, String dNA) {
		this.name1 = name;
		this.number1 = number;
		file_path = dNA;
	}

	/*
	 * For missing
	 */
	public DNArecord(String file_path, String details) {
		this.file_path = file_path;
		this.details= details;
	}

	/*
	 * For matching results
	 */
	 
	public DNArecord(int id, String details, double match) {
		this.details= details;
		this.id=id;
		this.match = match;
	}
	
	public String getName() {
		return name1;
	}

	public void setName(String name) {
		this.name1 = name;
	}

	public int getNumber() {
		return number1;
	}

	public void setNumber(int number) {
		this.number1 = number;
	}

	public String getDNA() {
		return file_path;
	}

	public void setDNA(String dNA) {
		file_path = dNA;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	public double getMatch() {
		return match;
	}
	public void setMatch(double match) {
		this.match = match;
	}
}