package com.capgemini.iplleagueanalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.util.*;

import com.capgemini.iplleagueanalysis.exception.IplAnalyserException;
import com.capgemini.iplleagueanalysis.model.BowlingData;
import com.capgemini.iplleagueanalysis.model.IplData;
import com.capgemini.opencsv.OpenCSVBuilder;


public class IplLeagueAnalyser {
	
	public static List<IplData> IplDataList;
	public static List<BowlingData> IplBowlingDataList;
	
	public int loadCSVData(String csvFile) {
		int numOfEntries=0;
		try {
			
			Reader reader=Files.newBufferedReader(Paths.get(csvFile));
			Iterator<IplData> iterator=new OpenCSVBuilder().getCSVFileIterator(reader,IplData.class);
			Iterable<IplData> csvIterable = () -> iterator;
			numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return numOfEntries;
	}
	
	public void loadDataToList(String csvFile) throws IplAnalyserException {
		try {
			Reader reader=Files.newBufferedReader(Paths.get(csvFile));
		    IplDataList = new CsvToBeanBuilder(reader).withType(IplData.class).build().parse();
		}
		catch(IOException e) {
			throw new IplAnalyserException("File path is incorrect",IplAnalyserException.ExceptionType.FILE_INCORRECT);
		}
	}
	
	public void loadBowlingDataToLIst(String csvFile)throws IplAnalyserException{
		try {
			Reader reader=Files.newBufferedReader(Paths.get(csvFile));
		    IplBowlingDataList = new CsvToBeanBuilder(reader).withType(BowlingData.class).build().parse();
		}
		catch(IOException e) {
			throw new IplAnalyserException("File path is incorrect",IplAnalyserException.ExceptionType.FILE_INCORRECT);
		}
	}
	
	public List<IplData> getTopBattingAverages(){
		List<IplData> sortedAvgList = IplDataList.stream()
				.sorted((player1, player2) -> Double.compare(player1.getAverage(), player2.getAverage()))
				.collect(Collectors.toList());
		Collections.reverse(sortedAvgList);
		return sortedAvgList;
	}
	
	//UC7......
	public List<BowlingData> getTopBowlingAverages(){
		List<BowlingData> sortedAvgBowlingList = IplBowlingDataList.stream()
				.sorted((player1, player2) -> Double.compare(player1.avg, player2.avg))
				.collect(Collectors.toList());
		Collections.reverse(sortedAvgBowlingList);
		return sortedAvgBowlingList;
	}
	
	public List<IplData> getTopStrikingRates() {
		List<IplData> sortedStrikingRateList = IplDataList.stream()
				.sorted((player1, player2) -> Double.compare(player1.getSR(), player2.getSR()))
				.collect(Collectors.toList());
		Collections.reverse(sortedStrikingRateList);
		return sortedStrikingRateList;
	}
	
	public List<IplData> getTopBatmenWithMax6s(){
		List<IplData> batmenWithMax6s = IplDataList.stream()
				.sorted((player1, player2) -> Double.compare(player1.get6s(), player2.get6s()))
				.collect(Collectors.toList());
		Collections.reverse(batmenWithMax6s);
		return batmenWithMax6s ;
	}
	
	public List<IplData> getTopBatmenWithMax4s(){
		List<IplData> batmenWithMax4s = IplDataList.stream()
				.sorted((player1, player2) -> Double.compare(player1.get4s(), player2.get4s()))
				.collect(Collectors.toList());
		Collections.reverse(batmenWithMax4s);
		return batmenWithMax4s ;
	}
	public List<IplData> getCricketerWithBestStrikingRateWith6sAnd4s(){
		int max4sAnd6s = IplDataList.stream()
				.map(player -> (player.get4s()+player.get6s()))
				.max(Integer::compare)
				.get();
		List<IplData> batmenWithMax4sAnd6s = IplDataList.stream()
				.filter((player -> (player.get6s()+player.get4s())==max4sAnd6s))
				.collect(Collectors.toList());
		
		double bestStrikingRate=batmenWithMax4sAnd6s.stream()
				.map(player -> player.getSR())
				.max(Double::compare)
				.get();
		
		List<IplData> batmenBestStrikingRateWithMax4sAnd6s = batmenWithMax4sAnd6s.stream()
				.filter(player->player.getSR()==bestStrikingRate)
				.collect(Collectors.toList());
		
		return batmenBestStrikingRateWithMax4sAnd6s ;
	}
	
	public List<IplData> getGreatestAverageWithBestStrikingRate(){
		double greatestAverage = IplDataList.stream()
				.map(player ->player.getAverage())
				.max(Double::compare)
				.get();
		List<IplData> cricketerWithGreatestAverage=IplDataList.stream()
				.filter(player->player.getAverage()==greatestAverage)
				.collect(Collectors.toList());
		double bestStrikeRate=cricketerWithGreatestAverage.stream()
				.map(player->player.getSR())
				.max(Double::compare)
				.get();
		List<IplData> batmenBestStrikingRateWithGreatestAverage =cricketerWithGreatestAverage.stream()
				.filter(player->player.getSR()==bestStrikeRate)
				.collect(Collectors.toList());
		
		return batmenBestStrikingRateWithGreatestAverage ;
	}
	
	public List<IplData> getMaximumRunWithGreatestAverage(){
		int maximumRun = IplDataList.stream()
				.map(player ->player.getRuns())
				.max(Integer::compare)
				.get();
		List<IplData> cricketerWithMaximumRun=IplDataList.stream()
				.filter(player->player.getRuns()==maximumRun)
				.collect(Collectors.toList());
		double greatestAverage=cricketerWithMaximumRun.stream()
				.map(player->player.getAverage())
				.max(Double::compare)
				.get();
		List<IplData> batmenBestStrikingRateWithGreatestAverage =cricketerWithMaximumRun.stream()
				.filter(player->player.getAverage()==greatestAverage)
				.collect(Collectors.toList());
		
		return batmenBestStrikingRateWithGreatestAverage ;
	}
	
}
