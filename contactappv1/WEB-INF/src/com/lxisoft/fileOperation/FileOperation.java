package com.lxisoft.metro.fileOperations;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class FileOperation{
	
	private FileReader fr;
	private FileWriter fw;
	private BufferedReader br;
	private BufferedWriter bw;
	
	
	public FileReader getFileReader(){
		return fr;
	}
	
	public void setFileReader(FileReader fr){
		this.fr=fr;	
	}
	
	public FileWriter getFileWriter(){
		return fw;
	}
	
	public void setFileWriter(FileWriter fw){
		this.fw=fw;	
	}
	
	public BufferedReader getBufferedReader(){
		return br;
	}
	
	public void setBufferedReader(BufferedReader br){
		this.br=br;	
	}
	
	public BufferedWriter getBufferedWriter(){
		return bw;
	}
	
	public void setBufferedWriter(BufferedWriter bw){
		this.bw=bw;	
	}
}