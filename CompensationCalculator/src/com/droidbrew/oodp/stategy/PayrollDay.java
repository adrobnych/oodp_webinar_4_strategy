package com.droidbrew.oodp.stategy;

public enum PayrollDay {
	MONDAY(PayType.WEEKDAY), 
	TUESDAY(PayType.WEEKDAY), 
	WEDNESDAY(PayType.WEEKDAY), 
	THURSDAY(PayType.WEEKDAY), 
	FRIDAY(PayType.WEEKDAY), 
	SATURDAY(PayType.WEEKENDDAY),
	SUNDAY(PayType.WEEKENDDAY);
	
	public enum PayType{
		WEEKDAY {
			@Override
			protected double overtimePay(double hours, double rate) {
				return hours <= HOURS_PER_SHIFT ? 0 :
					(hours - HOURS_PER_SHIFT) * rate;
			}
		},
		WEEKENDDAY {
			@Override
			protected double overtimePay(double hours, double rate) {
				return hours*rate;
			}
		};
		
		private static final int HOURS_PER_SHIFT = 8;

		public double pay(double hours, double rate) {
			if(hours < 0 || rate < 0 || hours > 24)
				return -1;
			return hours*rate + overtimePay(hours, rate);
		}

		
		abstract protected double overtimePay(double hours, double rate);
		
	}
	
	private PayType payType = null;
	
	public PayType getPayType() {
		return payType;
	}

	PayrollDay(PayType pt){
		this.payType = pt;
	}
}
