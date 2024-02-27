package co.edu.uniquindio.poo;

    public record Mascota(String nombre, String especie, String raza, String genero, String color,int edad, int peso) 
    {

        public Mascota{
            assert nombre != null && !nombre.isBlank();
            assert especie != null && !especie.isBlank();
            assert raza != null && !raza.isBlank();
            assert edad>0;
            assert genero != null && !genero.isBlank();
            assert color != null && !color.isBlank();
            assert peso >0;
        }
    }