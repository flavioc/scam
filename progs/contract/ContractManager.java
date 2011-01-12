
public interface ContractManager
{
	public void checkPreConditions(Object thisObject, Object[] args)
		throws ContractBrokeException;
	
	public void checkPostConditions(Object thisObject, Object returnValue,
			Object[] args)
		throws ContractBrokeException;

	public void checkInvariants(Object thisObject) throws ContractBrokeException;
}
