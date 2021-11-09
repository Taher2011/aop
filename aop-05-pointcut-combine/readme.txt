#Pointcut expression language :->
execution(modifiers-pattern?  return-type-pattern  declaring-type-pattern?  method-name-pattern(param-pattern)  throws-pattern?)

example :->
execution(public void com.udemy.aop.dao.AccountDAO.addAccount(Account) throws Exception)

Note : The pattern is optional if it has "?"

#JointPoint has metadata about method call

#AfterAdvice will always execute regardless of failure or success of target method, just like finally block
#AfterAdvice will always execute after AfterReturningAdvice in case of success
#AfterAdvice will always execute after AfterThrowingAdvice  in case of failure

BeforeAdvice         : run before execution of target method
AfterReturningAdvice : run after successful execution of target method
AfterThrowingAdvice  : run after target method throws an exception
AfterAdvice          : run after regardless of success/failure of target method i.e. finally block in java
