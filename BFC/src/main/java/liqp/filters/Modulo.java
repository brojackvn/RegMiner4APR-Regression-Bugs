package liqp.filters;

public class Modulo extends Filter {

    /*
     * modulo(input, operand)
     *
     * modulus
     */
    @Override
    public Object apply(Object value, Object... params) {

        if(value == null) {
            value = 0L;
        }

        super.checkParams(params, 1);

        Object rhsObj = params[0];

        if (super.canBeInteger(value) && super.canBeInteger(rhsObj)) {
            return super.asNumber(value).longValue() % super.asNumber(rhsObj).longValue();
        }

        return super.asNumber(value).doubleValue() % super.asNumber(rhsObj).doubleValue();
    }
}
