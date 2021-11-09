#Pointcut expression language :->
execution(modifiers-pattern?  return-type-pattern  declaring-type-pattern?  method-name-pattern(param-pattern)  throws-pattern?)

example :->
execution(public void com.udemy.aop.dao.AccountDAO.addAccount(Account) throws Exception)

Note : The pattern is optional if it has "?"

#JointPoint has metadata about method call
