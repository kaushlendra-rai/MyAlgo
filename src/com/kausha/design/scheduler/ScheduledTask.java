package com.kausha.design.scheduler;

import java.util.Date;

public class ScheduledTask extends Task {
	// While persisting (create/update), the code must evaluate the schedule time pattern and evaluate the time
	// when the job would be executed next. This would help in easy fetching of the tasks which need to be executed
	// in next minute with appropriate SQL.
	Date nextSchedule;
}
