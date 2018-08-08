package modules;

import io.ebean.config.CurrentUserProvider;


public class ApiUserProvider implements CurrentUserProvider {
    @Override
    public Object currentUser() {
        return 1L;
    }
}
