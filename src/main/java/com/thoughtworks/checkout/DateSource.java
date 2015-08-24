package com.thoughtworks.checkout;

import java.time.LocalDate;

public interface DateSource {
  LocalDate get();
}
