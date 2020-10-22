package com.capgemini.iplleagueanalysis;

import com.opencsv.bean.CsvBindByName;

public class IplData {
	
	@CsvBindByName(column = "POS")
	public int pos;
	
	@CsvBindByName(column = "PLAYER")
	public String player;
	
	@CsvBindByName(column = "Mat")
	public int mat;
	
	@CsvBindByName(column = "Inns")
	public int inns;
	
	@CsvBindByName(column = "NO")
	public int no;
	
	@CsvBindByName(column = "Runs")
	public int runs;
	
	@CsvBindByName(column = "HS")
	public int hs;
	
	@CsvBindByName(column = "Avg")
	public double avg;
	
	@CsvBindByName(column = "BF")
	public int bf;
	
	@CsvBindByName(column = "SR")
	public double sr;
	
	@CsvBindByName(column = "100")
	int num100;
	
	@CsvBindByName(column = "50")
	public int num50;
	
	@CsvBindByName(column = "4s")
	public int num4s;
	
	@CsvBindByName(column = "6s")
	public int num6s;
	
	public int getPos() {
		return this.pos;
	}
	public String getPlayer() {
		return this.player;
	}
	public int getMat() {
		return this.mat;
	}
	public int getInns() {
		return this.inns;
	}
	public int getNO() {
		return this.no;
	}
	public int getRuns() {
		return this.runs;
	}
	public int getHS() {
		return this.hs;
	}
	public int getBF() {
		return this.bf;
	}
	public double getSR() {
		return this.sr;
	}
	public int get100() {
		return this.num100;
	}
	public int get50() {
		return this.num50;
	}
	public int get4s() {
		return this.num4s;
	}
	public int get6s() {
		return this.num6s;
	}
	public double getAverage() {
		return this.avg;
	}
	
	@Override
	public String toString() {
		return "IplData{" + "Pos='" + pos + ", PLAYER='" + player 
				+ ", Mat='" + mat+", INNS='"+ inns +",NO='"+ no +", RUNS='"+runs+
				", HS='"+hs+",Avg='"+avg+",BF='"+bf+",sr='"+sr
				+",100s='"+num100+",50s='"+num50+",4s='"+num4s+",6s='"+num6s
				 + '}';
	}
}
