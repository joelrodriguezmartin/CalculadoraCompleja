package dad.javafx.calculadoracompleja;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;

public class MultiImaginBinding extends DoubleBinding {
	private DoubleExpression a, b, c, d;
	
	public MultiImaginBinding(DoubleExpression a, DoubleExpression b, DoubleExpression c, DoubleExpression d) {
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
		return a.get()*d.get()+b.get()*c.get();
	}

}
