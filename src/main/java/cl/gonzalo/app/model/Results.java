package cl.gonzalo.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Results {

    List<Characters> results;
}
