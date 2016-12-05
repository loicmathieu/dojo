package fr.loicmathieu.dojo.pattern.lambdaspec;



/**
 * Specification : represents a specification.
 *
 * Inspired by http://blog.xebia.fr/2009/12/29/le-pattern-specification-pour-la-gestion-de-vos-regles-metier/
 * and https://github.com/nicolaslecoz/java-sandbox/tree/master/src/main/java/patternSpecification
 *
 * User specifications needs to extends {@link LeafSpecification} or use the {@link LambdaSpecificationFactory}.
 *
 * Here are a code sample from the TU using only lambda specification:
 * <pre>
 *		Obj1 obj1 = new Obj1();
 *		obj1.setText("text");
 *		obj1.setNb(11);
 *		LambdaSpecificationFactory<Obj1> factory = new LambdaSpecificationFactory<>();
 *		LeafSpecification<Obj1> spec1 = factory.from(obj -> obj.getText() != null);
 *		LeafSpecification<Obj1> spec2 = factory.from(obj -> obj.getNb() > 10);
 *		LeafSpecification<Obj1> spec3 = factory.from(obj -> obj.getNb() < 1);
 *		boolean isSatisfied = spec1.and(spec2.or(spec3)).isSatisfiedBy(obj1);
 * </pre>
 *
 * Here are a code sample from the TU using only lambda LeafSpecification:
 * <pre>
 * 	public class Obj1HasNotNullText  extends LeafSpecification<Obj1>{
 *		public boolean isSatisfiedBy(Obj1 obj) {
 *			return obj.getText() != null;
 *		}
 * 	}
 *
 * 	public class Obj1NbLessThan1  extends LeafSpecification<Obj1> {
 *		public boolean isSatisfiedBy(Obj1 obj) {
 *			return obj.getNb() > 10;
 *		}
 * 	}
 *
 * 	public class Obj1NbMoreThan10  extends LeafSpecification<Obj1> {
 *		public boolean isSatisfiedBy(Obj1 obj) {
 *			return obj.getNb() > 10;
 *		}
 * 	}
 *
 * 	Obj1 obj1 = new Obj1();
 *	obj1.setText("text");
 *	obj1.setNb(9);
 *	Obj1HasNotNullText spec1 = new Obj1HasNotNullText();
 *	Obj1NbMoreThan10 spec2 = new Obj1NbMoreThan10();
 *	Obj1NbLessThan1 spec3 = new Obj1NbLessThan1();
 *	boolean isSatisfied = spec1.and(spec2.or(spec3)).isSatisfiedBy(obj1);
 * </pre>
 *
 * @author lmathieu
 *
 * @param <T> The objet type of the specification
 */
public interface Specification<T> {

	/**
	 * evaluation.
	 * @param t
	 * @return
	 */
	public boolean isSatisfiedBy(T obj);
}
