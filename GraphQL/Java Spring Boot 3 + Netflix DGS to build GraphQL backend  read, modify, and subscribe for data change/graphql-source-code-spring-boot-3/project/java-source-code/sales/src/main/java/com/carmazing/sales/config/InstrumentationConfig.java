package com.carmazing.sales.config;

import com.carmazing.sales.generated.DgsConstants;
import graphql.GraphQLError;
import graphql.execution.ResultPath;
import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.fieldvalidation.FieldAndArguments;
import graphql.execution.instrumentation.fieldvalidation.FieldValidationEnvironment;
import graphql.execution.instrumentation.fieldvalidation.FieldValidationInstrumentation;
import graphql.execution.instrumentation.fieldvalidation.SimpleFieldValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

@Configuration
public class InstrumentationConfig {

    private BiFunction<FieldAndArguments, FieldValidationEnvironment, Optional<GraphQLError>>
    ageMustBetween18To70() {
        return (fieldAndArguments, fieldValidationEnvironment) -> {
            Map<String, Object> argCustomer = fieldAndArguments.getArgumentValue(
                    DgsConstants.MUTATION.ADDNEWCUSTOMER_INPUT_ARGUMENT.Customer
            );
            var birthDate = (LocalDate)  argCustomer.getOrDefault(
                    DgsConstants.CUSTOMER.BirthDate, LocalDate.now()
            );
            var age = ChronoUnit.YEARS.between(birthDate, LocalDate.now());

            return (age < 18 || age > 70) ?
                    Optional.of(
                            fieldValidationEnvironment.mkError("Age must between 18-70, " +
                                    "currently " + age)
                    ) : Optional.empty();
        };
    }

    private BiFunction<FieldAndArguments, FieldValidationEnvironment, Optional<GraphQLError>>
    emailMustNotGmail() {
        return (fieldAndArguments, fieldValidationEnvironment) -> {
            Map<String, Object> argCustomer = fieldAndArguments.getArgumentValue(
                    DgsConstants.MUTATION.ADDNEWCUSTOMER_INPUT_ARGUMENT.Customer
            );
            var email = (String) argCustomer.get(DgsConstants.CUSTOMER.Email);

            return email.toLowerCase().endsWith("@gmail.com") ?
                    Optional.of(
                            fieldValidationEnvironment.mkError("Gmail is not allowed")
                    ) : Optional.empty();
        };
    }

    @Bean
    Instrumentation ageValidationInstrumentation() {
        var pathAddNewCustomer = ResultPath.parse("/" +
                DgsConstants.MUTATION.AddNewCustomer);
        var fieldValidation = new SimpleFieldValidation();

        fieldValidation.addRule(pathAddNewCustomer, ageMustBetween18To70());

        return new FieldValidationInstrumentation(fieldValidation);
    }

    @Bean
    Instrumentation emailValidationInstrumentation() {
        var pathAddNewCustomer = ResultPath.parse("/" +
                DgsConstants.MUTATION.AddNewCustomer);
        var fieldValidation = new SimpleFieldValidation();

        fieldValidation.addRule(pathAddNewCustomer, emailMustNotGmail());

        return new FieldValidationInstrumentation(fieldValidation);
    }

}
