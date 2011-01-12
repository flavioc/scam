
public abstract aspect AbstractContract {
	public abstract pointcut targetPointcut();

	public abstract ContractManager getContractManager();

	Object around(): targetPointcut() {
		ContractManager manager = getContractManager();
		System.out.println("Checking contract with " +
				manager.getClass().getName());

		if(manager != null) {
			System.out.println("Initial invariants check");
			manager.checkInvariants(thisJoinPoint.getTarget());

			System.out.println("Pre-conditions check");
			manager.checkPreConditions(thisJoinPoint.getTarget(),
					thisJoinPoint.getArgs());
		}

		Object obj = proceed();

		if(manager != null) {
			System.out.println("Post-conditions check");
			manager.checkPostConditions(thisJoinPoint.getTarget(),
					obj, thisJoinPoint.getArgs());

			System.out.println("Final invariants check");
			manager.checkInvariants(thisJoinPoint.getTarget());
		}
		return obj;
	}
}
