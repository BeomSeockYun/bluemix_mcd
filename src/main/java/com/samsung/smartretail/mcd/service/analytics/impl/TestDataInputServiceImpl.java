package com.samsung.smartretail.mcd.service.analytics.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.smartretail.mcd.dao.analytics.AnalyticsMapper;

@Service
public class TestDataInputServiceImpl {

    @Autowired
    private AnalyticsMapper analyticsMapper;

    private int[] historical_count = { 10, 4, 6, 8, 15, 34, 150, 180, 90,
	    100, 140, 250, 280, 100, 80, 95, 170, 180, 240, 280, 50, 5, 25 };
    private String[] time = { "01:00:00", "02:00:00", "03:00:00",
	    "04:00:00", "05:00:00", "06:00:00", "07:00:00", "08:00:00",
	    "09:00:00", "10:00:00", "11:00:00", "12:00:00", "13:00:00",
	    "14:00:00", "15:00:00", "16:00:00", "17:00:00", "18:00:00",
	    "19:00:00", "20:00:00", "21:00:00", "22:00:00", "23:00:00" };

    public void insertForecasetData() throws Exception {

	for (int prev = 0; prev < 5; prev++) {
	    String getCurrentDate = this.setOperationDate("minus", (prev*(-1)));
	    for (int i = 0; i < 23; i++) {
		String dateTime = getCurrentDate + " " + time[i];
		int seedNumber = this.historical_count[i];

		int history = this.generateHistoricalData(seedNumber);
		int forecast = this.generateForecastData(history);
		int today = this.generateCurrentData(forecast);

		SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
		Date parsedDate = dateFormat.parse(dateTime);
		Timestamp timestamp = new java.sql.Timestamp(
			parsedDate.getTime());

		this.analyticsMapper.insertForecastData(0, timestamp,
			timestamp, forecast);
		this.analyticsMapper.insertTodayData(0,timestamp, history);
		this.analyticsMapper.insertHistoryData(0,timestamp, today);

	    }
	}
    }

    /**
     * Delete data
     */
    public void deleteAnalyticsData(){
	this.analyticsMapper.deleteForecastInfo();
	this.analyticsMapper.deleteTodayInfo();
	this.analyticsMapper.deleteHistoryInfo();
    }

    private double getRandomVariation(double various) {
	double result = 0.0;

	Random random = new Random();
	result = random.nextDouble();
	// result limit is from 0 to 1
	result = (result - 0.5) * various;

	return result;
    }

    private int generateHistoricalData(int seedNumber) {
	int resultCount = 0;
	double variation = this.getRandomVariation(0.3);
	resultCount = seedNumber + (int) (seedNumber * variation);
	return resultCount;
    }

    /**
     * Generate forecast traffic info
     *
     * @param seedNumber
     * @return
     */
    private int generateForecastData(int seedNumber) {
	int resultCount = 0;
	double variation = this.getRandomVariation(0.5);
	resultCount = seedNumber + (int) (seedNumber * variation);
	return resultCount;
    }

    /**
     * Generate current traffic info
     *
     * @param seedNumber
     * @return
     */
    private int generateCurrentData(int seedNumber) {
	int resultCount = 0;
	double variation = this.getRandomVariation(0.7);
	resultCount = seedNumber + (int) (seedNumber * variation);

	return resultCount;
    }

    /**
     * Generate date
     *
     * @param mode
     * @param value
     * @return
     */
    private String setOperationDate(String mode, int value) {
	SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	GregorianCalendar cal = new GregorianCalendar();

	if (mode.equals("plus")) {
	    cal.add(Calendar.DATE, value); // 현재날짜에 value 값을 더한다.
	} else if (mode.equals("minus")) {
	    cal.add(Calendar.DATE, value); // 현재날짜에 value 값을 뺀다.
	}

	Date date = cal.getTime(); // 연산된 날자를 생성.
	String setDate = fmt.format(date);

	return setDate;
    }

/*    public static void main(String args[]){
	TestDataInputServiceImpl testImpl = new TestDataInputServiceImpl();
	Random random = new Random();
	random.setSeed(1L);

	for(int i=0;i<200;i++){
	    double result = random.nextDouble() - 0.5;
	    System.out.println("Gaussian Value : "+result);
	}
    }*/
}
