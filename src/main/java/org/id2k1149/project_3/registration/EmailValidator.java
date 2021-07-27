package org.id2k1149.project_3.registration;

import org.springframework.stereotype.Service;
import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String email) {
        // TODO validate email
        return true;
    }
}
