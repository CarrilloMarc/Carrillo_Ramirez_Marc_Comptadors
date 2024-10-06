# Unitat1_Comptadors

## Bloc 1: Activitats sobre el comptador

### Anàlisi de l'estructura del projecte

En aquesta activitat, se'ns proporciona un codi per al disseny d'una app en android, concretament la d'un marcador.
Aquest projecte utilitza Gradle per a construir l'aplicació en Android
Els fitxer i les carpetes més importants son:

**MainActivity.kt** : programa per a configurar el que anem a veure per pantalla i definir les funcions dels botons, en aquest cas sumarem, restarem, o reestablirem el contador

**MostraComptadorActivity** : programa on definim les funcions per a que les accions que executem, es guarden i es façen definitives al marcador; es guarden els estats
Aquests dos programes, es troben dins del directori kotlin+java de l'app.

**ActivityMain.xml** : arxiu xml on es defineix el disseny del que invoquem al main, en aquest cas dels botons. 

**Activity_mostra_comptador** : arxiu xml en el qual es defineix el marcador, tant el de fora de l'activitat com el de dins

A continuació, expliquem com funcionen les dos funcions les quals s'encarreguen de mantindre l'estat de les activitats, sent aquestes un canvi que es produeix al programa i el qual s'ha de manipular de manera correcta per a que afecte com i quan correspon al propi programa. Aquestes s'escriuen al propi MainActivity.kt, sent aquest l'unic fitxer implicat

>    override fun onSaveInstanceState(estat: Bundle){
>        super.onSaveInstanceState(estat)
>        estat.putInt("Comptador",comptador)
>    }
>    override fun onRestoreInstanceState(estat: Bundle){
>        super.onRestoreInstanceState(estat)
>        comptador=estat.getInt("Comptador")
>        val textViewComptador = findViewById<TextView>(R.id.textViewComptador)
>        textViewComptador.text= comptador.toString().toString()
>    }

Aquest son dos exemples, el qual la primera funció s'encarrega d'emmagatzemar l'informació que afecta a la variable comptador abans de la destrucció d'un procés (com pot ser el gir de la pantalla)
La segon, es la que s'encarrega de, una vegada reestablert l'estat, tornar les variables al estat inicial, és a dir, les restaura
Per últim, en quant a la resta de funcions comentades (onStart, onResume, onPause, onStop, onDestroy), son funcions les quals mostren informació de processos, per lo que no és necessari mostrar-les per pantalla almenys en aquesta activitat.


### Estructura i modificacions
Se'ns proporciona un codi en el qual estàn dissenyats els següents botons:
**Marcador** : Número que es mostra per pantalla, i sobre el qual repercutiràn tots els botons que dissenyem. Té la seua propia classe (mencionada abans); MostraComptadorActivity

**-** : És el únic botó que afecta al marcador que ens ve ja fet. Gràcies al codi picat per a programar-lo, tenim exemple de com fer la resta de botons

**Botons restants** S'ha efectuat a la creació del boto de resetejar i de sumar al marcador

### Questió: Per crear una nova activitat, seria suficient amb crear el fitxer XML amb el layout i el fitxer Kotlin amb el codi per gestionar-la?
No, es deuria declarar al AndroidManifest.xml el propi fitxer kotlin que hauríem de crear per a gestionar l'activitat.

Per últim, cal afegir que no és necessari crear la funcio de "Close" i "Back" que se'ns requereix a l'activitat, perque bàsicametn ja esta feta al propi codi 

## Bloc 2: Comptador amb MVVN
### Amb l'arquitectura MVVM, aquest seguiria sent necessari? No podem llançar la Intent sense proporcionar cap argument? Si modifiquem la segona activitat per a que faça ús també del ViewModel, no podriem accedir directament al valor? Investiga sobre aquesta possibilitat.
No és precís passar el valor del comptador entre activitats si les dos comparteixen el mateix ViewModel. De fet, aquesta és una de les ventajes de realitzar els projectes en MVVM, ja que simplifica molt els processos.
En quant al procés de creació, ha sigut molt semblant al anterior projecte explicat, amb la diferència de que no ha sigut necessari configuar per a que guarde l'estat de cada activitat

## Bloc 3: ComptadorComposable
En aquest projecte, s'ha tingut que rebuscar menys per a aplegar al mateix lloc en quant a execució. 
Havem creat els botons en la propia classe principal, i havem definit els espais entre ells.
La diferencia concreta, ha sigut la de definir la funció "Row", amb la qual havem definit les característiques que ens interessaven, i com podem vore havem col·locat dins els dos botons als que volíem que afectara la configuracio (el de "-" i el de "+")
Amb açò, i degut a la simplicitat en la manera de programar d'aquesta manera, havem aplegat al mateix final amb molt menys codi
