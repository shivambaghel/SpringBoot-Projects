package com.course.avro.tutorial;

import org.apache.avro.reflect.ReflectData;

import com.course.avro.entity.Company;

public class Avro10App {

	public static void main(String[] args) {
		var schema = ReflectData.get().getSchema(Company.class);
		System.out.println(schema.toString(true));
	}

}
