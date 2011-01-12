
public aspect ContractCompanySystem extends AbstractContract {
	public pointcut targetPointcut(): call(Customer CompanySystem.getCustomer(String));

	public ContractManager getContractManager() {
		return new CompanySystemContractManager();
	}
}
