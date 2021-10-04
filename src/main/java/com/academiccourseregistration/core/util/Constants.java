package com.academiccourseregistration.core.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

	//These can be configured in properties instead of hardcoding here
	//@Value{property name = property value}
    public static int STUDENT_MAX_COURSES = 3;

    public static int COURSE_MAX_STUDENTS = 50;
}
