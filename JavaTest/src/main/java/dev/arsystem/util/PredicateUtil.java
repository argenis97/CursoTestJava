package dev.arsystem.util;

import java.util.function.Predicate;

public class PredicateUtil {
	public static <T> Predicate<T> addPredicate(Predicate<T> initialPredicate, Predicate<T> added) {
		if (initialPredicate == null)
			return added;
		return initialPredicate.and(added);
	}
}
