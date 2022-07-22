package org.germandilio.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.germandilio.aopdemo")
@EnableAspectJAutoProxy
public class SpringConfig {
}
