package com.capgemini.iplleagueanalysis.model;

import com.opencsv.bean.CsvBindByName;

public class BowlingData {
	@CsvBindByName(column = "POS")
	public int pos;
	
	@CsvBindByName(column = "PLAYER")
	public String player;
	
	@CsvBindByName(column="Mat")
	public int mat;
	
	@CsvBindByName(column="Inns")
	public int inns;
	
	@CsvBindByName(column="Ov")
	public double ov;
	
	@CsvBindByName(column="Runs")
	public int runs;
	
	@CsvBindByName(column="Wkts")
	public int wkts;
	
	@CsvBindByName(column="BBI")
	public int bbi;
	
	@CsvBindByName(column="Avg")
	public double avg;
	
	@CsvBindByName(column="Econ")
	public double econ;
	
	@CsvBindByName(column="SR")
	public double sr;
	
	@CsvBindByName(column="4w")
	public int num4w;
	
	@CsvBindByName(column="5w")
	public int num5w;
	
	@Override
	public String toString() {
		return "IplData{" + "Pos='" + pos + ", PLAYER='" + player 
				+ ", Mat='" + mat+", INNS='"+ inns +",OV='"+ ov +", RUNS='"+runs+
				", Wkts='"+wkts+",BBI='"+bbi+",Avg='"+avg+",Econ='"+econ+",sr='"+sr
				+",4w='"+num4w+",5w='"+num5w
				 + '}';
	}
}
