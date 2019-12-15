package com.recipe.recipeapp.bootstrap;

import com.recipe.recipeapp.models.*;
import com.recipe.recipeapp.repositories.CategoryRepository;
import com.recipe.recipeapp.repositories.RecipeRepository;
import com.recipe.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@Profile("default")
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> cayKasigiOptional = unitOfMeasureRepository.findByDescription("Çay Kaşığı");

        if(!cayKasigiOptional.isPresent()){
            throw new RuntimeException("Bulunamadı");
        }

        Optional<UnitOfMeasure> yemekKasigiOptional = unitOfMeasureRepository.findByDescription("Yemek Kaşığı");

        if(!yemekKasigiOptional.isPresent()){
            throw new RuntimeException("Bulunamadı");
        }

        Optional<UnitOfMeasure> tatliKasigiOptional = unitOfMeasureRepository.findByDescription("Tatlı Kaşığı");

        if(!tatliKasigiOptional.isPresent()){
            throw new RuntimeException("Bulunamadı");
        }

        Optional<UnitOfMeasure> bardakOptional = unitOfMeasureRepository.findByDescription("Bardak");

        if(!bardakOptional.isPresent()){
            throw new RuntimeException("Bulunamadı");
        }

        Optional<UnitOfMeasure> tutamOptional = unitOfMeasureRepository.findByDescription("Tutam");

        if(!tutamOptional.isPresent()){
            throw new RuntimeException("Bulunamadı");
        }

        Optional<UnitOfMeasure> gramOptional = unitOfMeasureRepository.findByDescription("Gram");

        if(!gramOptional.isPresent()){
            throw new RuntimeException("Bulunamadı");
        }

        Optional<UnitOfMeasure> adetOptional = unitOfMeasureRepository.findByDescription("Adet");

        if(!adetOptional.isPresent()){
            throw new RuntimeException("Bulunamadı");
        }



        UnitOfMeasure cayKasigi = cayKasigiOptional.get();
        UnitOfMeasure yemekKasigi = yemekKasigiOptional.get();
        UnitOfMeasure tatliKasigi = tatliKasigiOptional.get();
        UnitOfMeasure bardak = bardakOptional.get();
        UnitOfMeasure tutam = tutamOptional.get();
        UnitOfMeasure gram = gramOptional.get();
        UnitOfMeasure adet = adetOptional.get();


        Optional<Category> corbaKategorisiOptional = categoryRepository.findByDescription("Çorba");

        if(!corbaKategorisiOptional.isPresent()){
            throw new RuntimeException("Bulunamadı");
        }

        Optional<Category> hamurKategorisiOptional = categoryRepository.findByDescription("Hamur İşi");

        if(!hamurKategorisiOptional.isPresent()){
            throw new RuntimeException("Bulunamadı");
        }

        Optional<Category> tatliKategorisiOptional = categoryRepository.findByDescription("Tatlı");

        if(!tatliKategorisiOptional.isPresent()){
            throw new RuntimeException("Bulunamadı");
        }

        Optional<Category> etYemekleriKategorisiOptional = categoryRepository.findByDescription("Et Yemekleri");

        if(!etYemekleriKategorisiOptional.isPresent()){
            throw new RuntimeException("Bulunamadı");
        }

        Optional<Category> salataKategorisiOptional = categoryRepository.findByDescription("Salata");

        if(!salataKategorisiOptional.isPresent()){
            throw new RuntimeException("Bulunamadı");
        }

        Category corbaKategorisi = corbaKategorisiOptional.get();
        Category hamurKategorisi = hamurKategorisiOptional.get();
        Category tatliKategorisi = tatliKategorisiOptional.get();
        Category etYemekleriKategorisi = etYemekleriKategorisiOptional.get();
        Category salataKategorisi = salataKategorisiOptional.get();

       //Pizza Napoli Tarifi
        Recipe pizzaRecipe = new Recipe();
        pizzaRecipe.setDescription("Napoli Usulü Pizza");
        pizzaRecipe.setPrepTime(20);
        pizzaRecipe.setCookTime(25);
        pizzaRecipe.setServings(3);
        pizzaRecipe.setDifficulty(Difficulty.ZOR);
        pizzaRecipe.setDirections("Ilık suyu yoğurma kabına alın. Maya ve şekeri ekleyip 5 dakika bekletin. Tuz ve zeytinyağı ekleyin." +
                " Unu azar azar ve eleyerek ilave edip 5 dakika yoğurun. Gerekirse un ekleyin. Üzerini örterek mayalanmaya bırakın." +
                "\n" +
                "Mozzarella ve domatesler yuvarlak olacak şekilde kesin. Kaparilerin fazla tuzunu almak için bir süre suda bekletin." +
                "\n" +
                "Pizza sosu için karıştırma kabına salça, yarım çay kaşığı tuz, 1 çay kaşığı kekik ve 3 yemek kaşığı zeytinyağını ekleyerek çırpın." +
                "\n" +
                "Hamuru unlanmış tezgahta elinizle bastırarak yuvarlak ve ince şekilde açın. Hazırlanan sosu üzerine gezdirin. " +
                "Önce yuvarlak mozzarellaları, daha sonra domates ve diğer malzemeleri pizza hamurunun üzerine yayın. " +
                "Hazırladığınız pizzayı, önceden ısıtılmış 180 derece fırında 15 dakika kadar pişirin. " +
                "Pizzayı fırından alıp kapari, fesleğen yaprakları, kekik ve zeytinyağıyla süsleyerek servis yapın.");

        Notes pizzaNotes = new Notes();
        pizzaNotes.setRecipeNotes("Napoli usulü pizza, hayranlığımın doruk noktalara ulaştığı bir pizza çeşididir;" +
                " bu türü neden bu denli övdüğümün cevabını, yurtdışı seyahatlerinde böyle bir pizza yiyerek tecrübe ederseniz, hatta anavatanı Napoli’de yerseniz, bulabilirsiniz.");

        pizzaRecipe.setNotes(pizzaNotes);

        pizzaRecipe.addIngredient(new Ingredient("un", new BigDecimal("3.5"), bardak));
        pizzaRecipe.addIngredient(new Ingredient("ılık su", new BigDecimal("1.5"), bardak));
        pizzaRecipe.addIngredient(new Ingredient("maya", new BigDecimal(1), yemekKasigi));
        pizzaRecipe.addIngredient(new Ingredient("şeker", new BigDecimal(1), tatliKasigi));
        pizzaRecipe.addIngredient(new Ingredient("zeytinyağı", new BigDecimal(5), yemekKasigi));
        pizzaRecipe.addIngredient(new Ingredient("mozzarella", new BigDecimal(2), yemekKasigi));
        pizzaRecipe.addIngredient(new Ingredient("çeri domates", new BigDecimal(7), adet));
        pizzaRecipe.addIngredient(new Ingredient("kapari", new BigDecimal(2), yemekKasigi));
        pizzaRecipe.addIngredient(new Ingredient("ton balığı", new BigDecimal(1), adet));
        pizzaRecipe.addIngredient(new Ingredient("domates salçası", new BigDecimal(1), yemekKasigi));
        pizzaRecipe.addIngredient(new Ingredient("taze fesleğen", new BigDecimal(5), adet));
        pizzaRecipe.addIngredient(new Ingredient("kekik", new BigDecimal(2), cayKasigi));
        pizzaRecipe.addIngredient(new Ingredient("tuz", new BigDecimal(3), cayKasigi));

        pizzaRecipe.getCategories().add(hamurKategorisi);


        recipes.add(pizzaRecipe);

        //Mantarlı Tavuk Çorbası Tarifi
        Recipe tavukCorbasiRecipe = new Recipe();
        tavukCorbasiRecipe.setDescription("Mantarlı Tavuk Çorbası");
        tavukCorbasiRecipe.setCookTime(20);
        tavukCorbasiRecipe.setPrepTime(40);
        tavukCorbasiRecipe.setServings(4);
        tavukCorbasiRecipe.setDifficulty(Difficulty.ORTA);

        tavukCorbasiRecipe.setDirections("Tavuk budunu, 1 dal kerevizi, 1 arpacık soğanı, yarım doğranmış havucu, 2 dal maydanozu ve 1 adet defne yaprağını bir tencereye alın, üzerine yaklaşık 8 bardak su ilave ederek kaynatın." +
                " Kaynayınca ocağın altını kısın ve tavuğun eti, kemiğinin üzerinden dökülene kadar yaklaşık 40 dakika haşlayın." +
                "\n" +
                "Mantarları temizleyip ince bir şekilde doğrayın. Ispanakları yıkayıp süzdükten sonra ince ince kıyın. Soğanı da küçük doğrayın." +
                "\n" +
                "Haşladığınız tavuk budunun etini kemiğinden ayırın ve suyunu süzün. Etleri çorbada yiyeceğiniz biçimde ve kaşığa sığacak şekilde didikleyin. " +
                "Süzdüğünüz tavuk suyunu bir kaba aktarırken bardakla ölçün ve üzerine toplam 8 bardak olacak şekilde su ilave edip sıcak kalmasını sağlayın." +
                "\n" +
                "Çorbayı yapacağınız tencereyi ocağa alın. Tencereyi hafifçe ısıtın. Zeytinyağını, tereyağını ve soğanları ekleyip 2-3 dakika kavurun. " +
                "Ardından unu ilave edin ve 4-5 dakika sürekli karıştırarak kavurun. " +
                "\n" +
                "Mantarları da ekleyin ve 1-2 dakika daha kavurun. Çorbanın suyunu eklerken bir çırpıcıyla ya da tahta bir kaşıkla topaklanmaması için sürekli karıştırın. " +
                "Ç̧orba kaynayınca tuzunu ilave edin. Ayırdığınız tavuk etlerini, makarnaları ve ıspanakları da ekleyip makarnalar haşlanıncaya kadar pişirin. " +
                "Son olarak karabiber ve kremayı da ekleyip ocaktan alın.");

        Notes tavukCorbasiNotes = new Notes();
        tavukCorbasiNotes.setRecipeNotes("İri çekilmiş karabiber tanelerinin aromasının mantarla nasıl güzel uyum gösterdiğini bu tarifte çok net görebilirsiniz.");

        tavukCorbasiRecipe.setNotes(tavukCorbasiNotes);


        tavukCorbasiRecipe.addIngredient(new Ingredient("tereyağı", new BigDecimal(1), yemekKasigi));
        tavukCorbasiRecipe.addIngredient(new Ingredient("zeytinyağı", new BigDecimal(2), yemekKasigi));
        tavukCorbasiRecipe.addIngredient(new Ingredient("soğan", new BigDecimal(1), adet));
        tavukCorbasiRecipe.addIngredient(new Ingredient("un", new BigDecimal(1), yemekKasigi));
        tavukCorbasiRecipe.addIngredient(new Ingredient("mantar", new BigDecimal(300), gram));
        tavukCorbasiRecipe.addIngredient(new Ingredient("makarna", new BigDecimal(1), bardak));
        tavukCorbasiRecipe.addIngredient(new Ingredient("ıspanak kökü", new BigDecimal(250), gram));
        tavukCorbasiRecipe.addIngredient(new Ingredient("tuz", new BigDecimal(1), tutam));
        tavukCorbasiRecipe.addIngredient(new Ingredient("karabiber", new BigDecimal(1), tutam));
        tavukCorbasiRecipe.addIngredient(new Ingredient("krema", new BigDecimal(1), adet));
        tavukCorbasiRecipe.addIngredient(new Ingredient("tavuk but", new BigDecimal(1), adet));
        tavukCorbasiRecipe.addIngredient(new Ingredient("kereviz sapı", new BigDecimal(1), adet));
        tavukCorbasiRecipe.addIngredient(new Ingredient("havuç", new BigDecimal(1), adet));


        tavukCorbasiRecipe.getCategories().add(corbaKategorisi);

        recipes.add(tavukCorbasiRecipe);
        return recipes;
    }
}
