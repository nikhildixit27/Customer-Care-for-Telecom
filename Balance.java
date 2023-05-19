//Inheritance (Abstract Class)

public abstract class Balance
{
    public abstract void CheckBalance() throws PlanNotActivatedException; //Throws Exception
    public abstract void RechargeBalance() throws PlanNotActivatedException; //Throws Exception
    public void BuyDataPlan() throws PlanNotActivatedException{} //Methord overriding 
    //Throws Exception
}