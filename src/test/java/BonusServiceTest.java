import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){
        BonusService service = new BonusService();
//        assertThrows(IllegalArgumentException.class,
//                () -> service.calcularBonus(new Funcionario("misael", LocalDate.now(), new BigDecimal("25000"))));
//        try {
//            service.calcularBonus(new Funcionario("misael", LocalDate.now(), new BigDecimal("25000")));
//            fail("Nao deu a exception!");
//        }catch (Exception e){
//
//        };
        try {
            service.calcularBonus(new Funcionario("misael", LocalDate.now(), new BigDecimal("25000")));
            fail("Nao deu a exception!");
        }catch (Exception e){
            assertEquals("Funcionario com salario maior do que R$10000 nao pode receber Bonus!",e.getMessage());
        }
    }

    @Test
    void bonusDeveriaSerDezPorcentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("misael", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorcentoParaSalarioDeExatamenteDezMilReais(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("misael", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.0"), bonus);
    }

}
