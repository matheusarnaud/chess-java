import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interface Grafica de uma Casa no tabuleiro do jogo.
 *
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class CasaGUI extends JButton {

    // Constantes 
    public static final Color COR_CLARA = new Color(254, 254, 220);
    public static final Color COR_ESCURA = new Color(178, 151, 72);
    private static final Color COR_DESTAQUE = new Color(8, 211, 225, 127);
    
    // Icones das pecas
    private static final Icon PEAO_BRANCO = new ImageIcon("imagens/peao_branco.png");
    private static final Icon CAVALO_BRANCO = new ImageIcon("imagens/cavalo_branco.png");
    private static final Icon BISPO_BRANCO = new ImageIcon("imagens/bispo_branco.png");
    private static final Icon TORRE_BRANCA = new ImageIcon("imagens/torre_branca.png");
    private static final Icon RAINHA_BRANCA = new ImageIcon("imagens/rainha_branca.png");
    private static final Icon REI_BRANCO = new ImageIcon("imagens/rei_branco.png");
    private static final Icon PEAO_PRETO = new ImageIcon("imagens/peao_preto.png");
    private static final Icon CAVALO_PRETO = new ImageIcon("imagens/cavalo_preto.png");
    private static final Icon BISPO_PRETO = new ImageIcon("imagens/bispo_preto.png");
    private static final Icon TORRE_PRETA = new ImageIcon("imagens/torre_preta.png");
    private static final Icon RAINHA_PRETA = new ImageIcon("imagens/rainha_preta.png");
    private static final Icon REI_PRETO = new ImageIcon("imagens/rei_preto.png");
    
    
    // Cores das pecas
    public static final int SEM_PECA = -1;
    public static final int PECA_BRANCA = 0;
    public static final int PECA_PRETA = 1;
    

    private int x;
    private int y;
    private Color cor;

    public CasaGUI(int x, int y, Color cor, TabuleiroGUI tabuleiro) {
        this.x = x;
        this.y = y;
        this.cor = cor;
        setIcon(null);

        // Layout e cor
        setBackground(cor);
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(cor, 1));
        setContentAreaFilled(false);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabuleiro.getJanela().reagir((CasaGUI) e.getSource());
            }
        });
    }

    public int getPosicaoX() {
        return x;
    }

    public int getPosicaoY() {
        return y;
    }

    public void desenharPeaoBranco() {
        setIcon(PEAO_BRANCO);
    }
    
    public void desenharCavaloBranco() {
        setIcon(CAVALO_BRANCO);
    }
    
    public void desenharBispoBranco() {
        setIcon(BISPO_BRANCO);
    }
    
    public void desenharTorreBranca() {
        setIcon(TORRE_BRANCA);
    }
    
    public void desenharRainhaBranca() {
        setIcon(RAINHA_BRANCA);
    }
    
    public void desenharReiBranco() {
        setIcon(REI_BRANCO);
    }
    
    public void desenharPeaoPreto() {
        setIcon(PEAO_PRETO);
    }
    
    public void desenharCavaloPreto() {
        setIcon(CAVALO_PRETO);
    }
    
    public void desenharBispoPreto() {
        setIcon(BISPO_PRETO);
    }
    
    public void desenharTorrePreta() {
        setIcon(TORRE_PRETA);
    }
    
    public void desenharRainhaPreta() {
        setIcon(RAINHA_PRETA);
    }
    
    public void desenharReiPreto() {
        setIcon(REI_PRETO);
    }

    public void apagarPeca() {
        setIcon(null);
    }

    public boolean possuiPeca() {
        return getIcon() != null;
    }
    
    public int getCorPeca() {
        Icon icone = getIcon();
        
        if (icone == PEAO_BRANCO || icone == CAVALO_BRANCO || icone == BISPO_BRANCO || icone == TORRE_BRANCA || icone == RAINHA_BRANCA || icone == REI_BRANCO) {
            return PECA_BRANCA;
        }
        else if (icone == PEAO_PRETO || icone == CAVALO_PRETO || icone == BISPO_PRETO || icone == TORRE_PRETA || icone == RAINHA_PRETA || icone == REI_PRETO) {
             return PECA_PRETA;
        }
        else {
            return SEM_PECA;
        }
    }
    
    public void destacar() {
        setBackground(COR_DESTAQUE);
    }

    public void atenuar() {
        setBackground(cor);
    }

    /**
     * Pinta o componente com a cor de fundo, aceita valores RGBA
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

}
