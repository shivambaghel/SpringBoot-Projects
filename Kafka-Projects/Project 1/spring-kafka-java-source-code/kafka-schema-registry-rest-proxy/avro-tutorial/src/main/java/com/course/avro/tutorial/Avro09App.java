package com.course.avro.tutorial;

import org.apache.avro.reflect.ReflectData;

import com.course.avro.entity.SimpleEntity;

public class Avro09App {

	public static void main(String[] args) {
		var schema = ReflectData.get().getSchema(SimpleEntity.class);
		System.out.println(schema.toString(true));
	}

}
