package magazine.aspects;

import magazine.exceptions.NotAuthorizedException;
import magazine.model.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class SecurityAspect {
    private ApplicationContext applicationContext;

    public void checkAuthorize() {
        Auth auth = applicationContext.getBean("userAuthorized", Auth.class);
        if (!auth.getAuthorized()) {
            throw new NotAuthorizedException("User is not authorized!");
        }
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
