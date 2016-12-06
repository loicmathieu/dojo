package fr.loicmathieu.dojo.pattern.lambdaspec;


/**
 * LeafSpecification : this is the class that user needs to extends to implements their specification.
 * It also contains a static factory method to easily create Specification object from a lambda.
 *
 * @author lmathieu
 *
 * @param <T> The objet type of the specification
 */
public abstract class LeafSpecification<T> extends AbstractCompositeSpecification<T>{

	/**
	 * Factory static method to create a LeafSpecification from a Specification.
	 * Designed to be used by lambdas.
	 *
	 * @param spec
	 *
	 * @return a LeafSpecification who's isSatisfiedBy method is implemented by the given Specification
	 */
	public static <T> LeafSpecification<T> from(Specification<T> spec){
		return new LambdaSpecification<>(spec);
	}

	/**
	 * Package private static classes that represent a Lambda implemented LeafSpecification
	 *
	 * @author lmathieu
	 *
	 * @param <T>
	 */
	static class LambdaSpecification<T> extends LeafSpecification<T> {
		private Specification<T> s;

		/**
		 * Private constructor : only the enclosing class can create instances of LambdaSpecification
		 * @param s
		 */
		LambdaSpecification(Specification<T> s){
			this.s = s;
		}

		/**
		 * @inheritDoc
		 */
		@Override
		public boolean isSatisfiedBy(T obj) {
			return s.isSatisfiedBy(obj);
		}

	}
}
