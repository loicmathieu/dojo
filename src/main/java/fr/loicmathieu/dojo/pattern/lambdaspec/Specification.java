package fr.loicmathieu.dojo.pattern.lambdaspec;



/**
 * Specification : represents a specification.
 *
 * Inspired by http://blog.xebia.fr/2009/12/29/le-pattern-specification-pour-la-gestion-de-vos-regles-metier/
 * and https://github.com/nicolaslecoz/java-sandbox/tree/master/src/main/java/patternSpecification
 *
 * User specifications needs to extends {@link LeafSpecification} or use the {@link LeafSpecification.from(Specification)} that allows creating
 * a specification with a lambda.
 *
 * Here are a code sample from the TU using only lambda specification:
 * <pre>
 *		Obj1 obj1 = new Obj1();
 *		obj1.setText("text");
 *		obj1.setNb(11);
 *		LeafSpecification<Obj1> spec1 = LeafSpecification.from(obj -> obj.getText() != null);
 *		LeafSpecification<Obj1> spec2 = LeafSpecification.from(obj -> obj.getNb() > 10);
 *		LeafSpecification<Obj1> spec3 = LeafSpecification.from(obj -> obj.getNb() < 1);
 *		boolean isSatisfied = spec1.and(spec2.or(spec3)).isSatisfiedBy(obj1);
 * </pre>
 *
 * Here are a code sample from the TU using only LeafSpecification standard implementation :
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
@FunctionalInterface
public interface Specification<T> {

	/**
	 * Evaluation of the Specification.
	 *
	 * @param obj the object to evaluate
	 *
	 * @return true if the specification is satisfied by the object
	 */
	public boolean isSatisfiedBy(T obj);
}
