package dad.javafx.calculadoracompleja;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;

public class DivImaginBinding extends DoubleBinding {
	private DoubleExpression a, b, c, d;
	
	public DivImaginBinding(DoubleExpression a, DoubleExpression b, DoubleExpression c, DoubleExpression d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		bind(a, b, c, d);
	}
	@Override
	protected double computeValue() {
		// TODO Auto-generated method stub
		return (b.get()*c.get()-a.get()*d.get())/(Math.pow(c.get(), 2) + Math.pow(d.get(), 2));
	}

}
