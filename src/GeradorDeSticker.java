package src;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GeradorDeSticker {

    public void cria(InputStream inputStream, String nomeArquivo) throws IOException {


        // leitura da imagem
        BufferedImage imagemOrinal = ImageIO.read(inputStream);

        // cria nova imagem em memoria com transparencia e com o tamanho novo
        int largura = imagemOrinal.getWidth();
        int altura = imagemOrinal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra nova imagem ( em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOrinal, 0, 0,null);

        // configurar a fonte
        var fonte =  new Font(Font.SANS_SERIF, Font.BOLD, 60);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("DAHORA!",100,novaAltura - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
}
