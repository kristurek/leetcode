package com.kristurek.leetcode.usaa;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class USAA {

    public double power(int x, int n) {
	if (x < 0 || n < 0)
	    throw new IllegalArgumentException("Arguments cannot be < 0");

	if (n == 0)
	    return 1;

	double temp = power(x, n / 2);

	if (n % 2 == 0)
	    return temp * temp;
	else {
	    if (n > 0)
		return (temp * temp) * x;
	    else
		return (temp * temp) / x;
	}
    }

    abstract class Food {
	public abstract void serveFood();
    }

    class FastFood extends Food {

	@Override
	public void serveFood() {
	    System.out.println("I'm serving FastFood");
	}

    }

    class Fruit extends Food {

	@Override
	public void serveFood() {
	    System.out.println("I'm serving Fruit");
	}
    }

    class FactoryFood extends Food {

	@Override
	public void serveFood() {
	    System.out.println("I'm serving Food");
	}

	public Food getFood(String name) {
	    if (name == null)
		throw new IllegalArgumentException();

	    if (name.equals("FastFood"))
		return new FastFood();
	    else if (name.equals("Food"))
		return new Fruit();
	    else
		throw new IllegalArgumentException();
	}
    }

    public int getTeams(String skills) {
	Map<Character, Integer> map = new HashMap<>(); // count students by skills, key=subject, val=counter

	for (Character subject : skills.toCharArray()) {
	    // map.put(subject, map.getOrDefault(subject, 0));
	    if (map.containsKey(subject))
		map.put(subject, map.get(subject) + 1);
	    else
		map.put(subject, 1);
	}

	// team must consist from 5 students with different skills, so in map must
	// exists min five subjects
	if (map.keySet().size() < 5)
	    return 0; // we cannot build any team

	// search lowest sum of students in subjects
	// lowest/min value will be our number of teams
	return Collections.min(map.values());
    }

    // Responseafter REST POST - 201 Created
    // Threads - undefined order
    // 
    
    public static int di(int a, int b) {// Print E next F
	Map<Character, Integer> map = new HashMap<>();
	for (Character subject : "".toCharArray())
	    map.put(subject, map.getOrDefault(subject, 0));

	int c = -1;
	try {
	    c = a / b;
	} catch (Exception ex) {
	    System.out.println("E");

	} finally {
	    System.out.println("F");
	}
	return c;
    }

}
