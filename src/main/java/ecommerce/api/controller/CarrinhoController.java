package ecommerce.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.api.model.Carrinho;
import ecommerce.api.model.FormaDePagamento;
import ecommerce.api.repository.CarrinhoRepository;

@RequestMapping("/carrinho")
@RestController
public class CarrinhoController {
    @PostMapping
    public Carrinho cadastroCarrinho(@RequestBody @NonNull Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    @GetMapping
    public List<Carrinho> listarProdutos() {
        return carrinhoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deletarCarrinho(@PathVariable("id") long id) {
        carrinhoRepository.deleteById(id);
        return "carrinho deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public Carrinho atualizarCarrinho(@PathVariable("id") long id, @RequestBody Carrinho carrinho) {
        Optional<Carrinho> carrinhoOpt = carrinhoRepository.findById(id);
        if (carrinhoOpt.isPresent()) {
            Carrinho carrinhoObj = carrinhoOpt.get();
        carrinhoObj.setCepDestino(carrinho.getCepDestino());
        carrinhoObj.setCepOrigem(carrinho.getCepOrigem());
        carrinhoObj.setQuantidadeItem(carrinho.getQuantidadeItem());
        carrinhoObj.setValorFrete(carrinho.getValorFrete());
        carrinhoObj.setPagamento(carrinho.getPagamento());

        if (carrinho.getPagamento() == FormaDePagamento.CARTAO){
            
           carrinhoObj.setCartao(carrinho.getCartao());

        }

        

        return carrinhoRepository.save(carrinhoObj);
        }

        return null;
    }


    @Autowired
    private CarrinhoRepository carrinhoRepository;
}