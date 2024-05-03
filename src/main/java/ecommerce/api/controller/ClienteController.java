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

import ecommerce.api.model.Cliente;
import ecommerce.api.repository.ClienteRepository;

@RequestMapping("/clientes")
@RestController
public class ClienteController {
    

    @PostMapping
    public Cliente cadastroCliente(@RequestBody @NonNull Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable("id") long id) {
        clienteRepository.deleteById(id);
        return "Cliente deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable("id") long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if (clienteOpt.isPresent()) {
            Cliente clienteObj = clienteOpt.get();

            clienteObj.setNome(cliente.getNome());
            clienteObj.setSobreNome(cliente.getSobreNome());
            clienteObj.setEmail(cliente.getEmail());
            clienteObj.setTelefone(cliente.getTelefone());
            clienteObj.setDataNasc(cliente.getDataNasc());
            clienteObj.setCep(cliente.getCep());

            return clienteRepository.save(clienteObj);
        }

        return null;
    }

    @Autowired
    private ClienteRepository clienteRepository;

}
