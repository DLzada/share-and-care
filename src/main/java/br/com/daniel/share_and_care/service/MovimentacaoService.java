package br.com.daniel.share_and_care.service;

import br.com.daniel.share_and_care.domain.Doador;
import br.com.daniel.share_and_care.domain.Estoque;
import br.com.daniel.share_and_care.domain.Item;
import br.com.daniel.share_and_care.domain.Movimentacao;
import br.com.daniel.share_and_care.domain.enums.TipoMovimentacao;
import br.com.daniel.share_and_care.dto.MovimentacaoRequestDTO;
import br.com.daniel.share_and_care.infra.exception.BusinessException;
import br.com.daniel.share_and_care.repository.EstoqueRepository;
import br.com.daniel.share_and_care.repository.MovimentacaoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovimentacaoService {
    private final MovimentacaoRepository movimentacaoRepository;
    private final EstoqueRepository estoqueRepository;
    private final ItemService itemService;
    private final DoadorService doadorService;

    @Transactional
    public Movimentacao registrar(MovimentacaoRequestDTO dto){
        Item item = itemService.buscarPorId(dto.itemId());

        Estoque estoque = estoqueRepository.findByItemId(item.getId())
                .orElseGet(()->{
                    Estoque novoEstoque = new Estoque();
                    novoEstoque.setItem(item);
                    novoEstoque.setQuantidadeAtual(0);
                    return novoEstoque;
                });

        if(dto.tipo() == TipoMovimentacao.ENTRADA){
            estoque.setQuantidadeAtual(estoque.getQuantidadeAtual() + dto.quantidade());
        } else{
            if(estoque.getQuantidadeAtual() < dto.quantidade()){
                throw new BusinessException("Estoque insuficiente! VOce tentou retirar %d , porem so tem %d no estoque", dto.quantidade(), estoque.getQuantidadeAtual());
            }
            estoque.setQuantidadeAtual(estoque.getQuantidadeAtual() - dto.quantidade());
        }

        estoqueRepository.save(estoque);

        Doador doador = null;
        if(dto.doadorId() != null){
            doador = doadorService.buscarPorId(dto.doadorId());
        }

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setItem(item);
        movimentacao.setDoador(doador);
        movimentacao.setTipo(dto.tipo());
        movimentacao.setQuantidade(dto.quantidade());
        movimentacao.setObservacao(dto.observacao());

        return movimentacaoRepository.save(movimentacao);
    }
}
