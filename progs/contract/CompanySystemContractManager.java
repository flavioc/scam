
public class CompanySystemContractManager implements ContractManager {
	public void checkPreConditions(Object thisObject, Object[] args)
		throws ContractBrokeException {
		if(args[0] == null)
			throw new ContractBrokeException("Pre Error: argument must be non-null");
	}

	public void checkPostConditions(Object thisObject, Object value,
			Object[] args) throws ContractBrokeException {
		if(value == null)
			throw new ContractBrokeException("Post Error: return value must be non-null");
	}

	public void checkInvariants(Object thisObject) throws ContractBrokeException {
	}
}
