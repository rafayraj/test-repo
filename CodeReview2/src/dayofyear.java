
public class  dayofyear 
{
	//Some Modification
	public void main(String[] args) 
	{
    final Month january = Month.getMonthForIndex(1);
    final YearMonth january2016 = new YearMonth(2016, january);
    final int dayOfYearJanuary2016Day1 = january2016.dayOfYear(1);
    System.out.println("Day of Year 2016 for January Day 1: " + dayOfYearJanuary2016Day1);

    final Month march = Month.getMonthForIndex(3);
    final YearMonth march2014 = new YearMonth(2014, march);
    final int dayOfYearMarch2014Day2 = march2014.dayOfYear(2);
    System.out.println("Day of Year 2014 for March Day 2: " + dayOfYearMarch2014Day2);
}

	public enum Month {

	    JAN(1, 31, 31),
	    FEB(2, 28, 29),
	    MAR(3, 31, 31),
	    APR(4, 30, 30),
	    MAY(5, 31, 31),
	    JUN(6, 30, 30),
	    JUL(7, 31, 31),
	    AUG(8, 31, 31),
	    SEP(9, 30, 30),
	    OCT(10, 31, 31),
	    NOV(11, 30, 30),
	    DEC(12, 31, 31);

	    private final int monthIndex;
	    private final int numberOfDaysInNonLeapYear;
	    private final int numberOfDaysInLeapYear;

	    Month(int monthIndex, int numberOfDaysInNonLeapYear, int numberOfDaysInLeapYear) {
	        this.monthIndex = monthIndex;
	        this.numberOfDaysInNonLeapYear = numberOfDaysInNonLeapYear;
	        this.numberOfDaysInLeapYear = numberOfDaysInLeapYear;
	    }

	    public int getNumberOfDaysInNonLeapYear() {
	        return numberOfDaysInNonLeapYear;
	    }

	    public int getNumberOfDaysInLeapYear() {
	        return numberOfDaysInLeapYear;
	    }

	    public int getMonthIndex() {
	        return monthIndex;
	    }

	    static Month getMonthForIndex(final int index) {
	        final Month[] months = Month.values();
	        for (final Month month : months) {
	            if (month.monthIndex == index) {
	                return month;
	            }
	        }
	        return null;
	    }
	}

	public class YearMonth {

	    private final Month month;
	    private final boolean isLeapYear;
	    private final int yearValue;

	    public YearMonth(final int yearValue, final Month month) {
	        this.yearValue = yearValue;
	        this.month = month;
	        if (yearValue % 4 == 0) {
	            isLeapYear = true;
	        } else {
	            isLeapYear = false;
	        }
	    }

	    public final int numberOfDays() {
	        if (isLeapYear) {
	            return month.getNumberOfDaysInLeapYear();
	        }
	        return month.getNumberOfDaysInNonLeapYear();
	    }

	    public final int dayOfYear(final int dayOfMonth) {
	        int dayOfYear = 0;
	        int monthIndex = month.getMonthIndex() - 1;

	        while (monthIndex != 0) {
	            final Month previousMonth = Month.getMonthForIndex(monthIndex);
	            final YearMonth yearPreviousMonth = new YearMonth(yearValue, previousMonth);
	            dayOfYear = dayOfYear + yearPreviousMonth.numberOfDays();
	            monthIndex--;
	        }

	        return dayOfYear + dayOfMonth;
	    }
	}
	

}
