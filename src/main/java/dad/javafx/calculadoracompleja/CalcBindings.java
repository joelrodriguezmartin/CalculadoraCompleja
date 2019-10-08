package dad.javafx.calculadoracompleja;


import javafx.beans.binding.DoubleExpression;

public class CalcBindings {
	public static MultiRealBinding multireal(DoubleExpression a, DoubleExpression b, DoubleExpression c, DoubleExpression d){
		return new MultiRealBinding(a, b, c, d);
	}
	public static MultiImaginBinding multiimagin(DoubleExpression a, DoubleExpression b, DoubleExpression c, DoubleExpression d){
		return new MultiImaginBinding(a, b, c, d);
	}
	public static DivImaginBinding divimagin(DoubleExpression a, DoubleExpression b, DoubleExpression c, DoubleExpression d){
		return new DivImaginBinding(a, b, c, d);
	}
	public static DivRealBinding divreal(DoubleExpression a, DoubleExpression b, DoubleExpression c, DoubleExpression d){
		return new DivRealBinding(a, b, c, d);
	}
}
