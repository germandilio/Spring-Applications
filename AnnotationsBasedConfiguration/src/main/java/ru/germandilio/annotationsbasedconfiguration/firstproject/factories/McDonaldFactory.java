package ru.germandilio.annotationsbasedconfiguration.firstproject.factories;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.germandilio.annotationsbasedconfiguration.firstproject.suppiers.EnergySupplier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
@Scope("prototype")
@Getter
@Setter
public class McDonaldFactory implements Factory {
    /**
     * Dependency injection can also be applied to fields directly with @Autowired annotation, and no setters are required.
     * In case where you need to place properties, you can use @Value annotation with properties placeholder.
     */
    @Value("${McDonaldFactory.address}")
    private String address;
    @Value("${McDonaldFactory.email}")
    private String email;

    private final EnergySupplier energySupplier;

    @Autowired
    public McDonaldFactory(@Qualifier("simpleEnergySupplier") EnergySupplier energySupplier) {
        this.energySupplier = energySupplier;
    }

    @Override
    public String produce() {
        final int amountOfEnergy = 10;
        energySupplier.getEnergy(amountOfEnergy);

        return String.format("New Big Tasty. Energy used: %d", amountOfEnergy);
    }

    /**
     * Custom init method (called after Spring initialize object and construct all dependencies)
     */
    @PostConstruct
    public void init() {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("src", "main", "resources", "destroy.txt"))) {
            var stringBuilder = new StringBuilder();

            String cachedLine;
            while((cachedLine = reader.readLine()) != null) {
                stringBuilder.append(cachedLine);
            }

            System.out.println(stringBuilder);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Custom destroy method, called before Spring destroy object
     * Because of @Scope("prototype") annotation, this method will NOT be called.
     */
    @PreDestroy
    public void destroy() {
    }
}
