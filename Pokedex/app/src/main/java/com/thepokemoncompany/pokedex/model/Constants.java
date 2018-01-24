package com.thepokemoncompany.pokedex.model;

import android.provider.BaseColumns;

/**
 * Created by giori on 18/01/2018.
 */

public class Constants {

    private Constants(){}

    public static class TablePokemon implements BaseColumns{

        public static final String TABLE_NAME = "pokemon";

        public static final String COLUMN_NUMBER = "p_number";
        public static final String COLUMN_NAME = "p_name";
        public static final String COLUMN_IMAGE = "p_image";
        public static final String COLUMN_HEIGHT = "p_height";
        public static final String COLUMN_WEIGHT = "p_weight";
        public static final String COLUMN_ABILITIES = "p_abilities";

        public static final String COLUMN_HP = "p_hp";
        public static final String COLUMN_ATTACK = "p_attack";
        public static final String COLUMN_DEFENSE = "p_defense";
        public static final String COLUMN_SP_ATTACK = "p_sp_attack";
        public static final String COLUMN_SP_DEFENSE = "p_sp_defense";
        public static final String COLUMN_SPEED = "p_speed";
        public static final String COLUMN_TOTAL = "p_total";

        public static final String COLUMN_BASE_EXP = "p_base_exp";
        public static final String COLUMN_CAPTURE_RATE = "p_capture_rate";
        public static final String COLUMN_GROWTH_RATE = "p_growth_rate";

        public static final String COLUMN_GENDER_FEMALE = "p_gender_female";
        public static final String COLUMN_MOVEMENTS = "p_movements";

        public static final String COLUMN_IS_CATCH = "m_catch";
        public static final String COLUMN_IS_MY_TEAM = "m_is_team";
    }

    public static class CallbackMessage{

        public static final int SUCCESS = 0;
        public static final int ERROR = -1;
        public static final int GET_DATA_POKEMON = 1;
        public static final int GET_EXTENDED_DATA = 2;

    }

}
