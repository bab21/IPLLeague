package iplleagueanalysis;

import static org.junit.Assert.*;

import org.junit.Test;

public class IplLeagueAnalysisTester {

	@Test
	public void givenIplDataWhenCalculatedBattingAverageShouldReturnExactAnswer() {
		assertEquals(123,new IplLeagueAnalyser().getBattingAverage());
	}

}
