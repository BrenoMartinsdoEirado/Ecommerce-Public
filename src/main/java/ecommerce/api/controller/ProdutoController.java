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

import ecommerce.api.model.Produto;
import ecommerce.api.repository.ProdutoRepository;


@RequestMapping("/produtos")
@RestController
public class ProdutoController {
     @PostMapping
    public Produto cadastroProduto(@RequestBody @NonNull Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable("id") long id) {
        produtoRepository.deleteById(id);
        return "Produto deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable("id") long id, @RequestBody Produto produto) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isPresent()) {
            Produto produtoObj = produtoOpt.get();

            produtoObj.setDescricao(produto.getDescricao());
            produtoObj.setCategoria(produto.getCategoria());
            produtoObj.setPeso(produto.getPeso());
            produtoObj.setAltura(produto.getAltura());
            produtoObj.setLargura(produto.getLargura());
            produtoObj.setProfundidade(produto.getProfundidade());
            produtoObj.setValor(produto.getValor());
    
            return produtoRepository.save(produtoObj);
        }

        return null;
    }

    @Autowired
    private ProdutoRepository produtoRepository;
}
