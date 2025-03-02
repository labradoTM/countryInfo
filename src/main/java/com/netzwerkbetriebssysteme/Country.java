package com.netzwerkbetriebssysteme;

public enum Country {
    USA("United States of America"),
    AFGHANISTAN("Afghanistan"),
    ALBANIA("Albania"),
    ALGERIA("Algeria"),
    ANDORRA("Andorra"),
    ANGOLA("Angola"),
    ANTIGUA_DEPS("Antigua & Deps"),
    ARGENTINA("Argentina"),
    ARMENIA("Armenia"),
    AUSTRALIA("Australia"),
    AUSTRIA("Austria"),
    AZERBAIJAN("Azerbaijan"),
    BAHAMAS("Bahamas"),
    BAHRAIN("Bahrain"),
    BANGLADESH("Bangladesh"),
    BARBADOS("Barbados"),
    BELARUS("Belarus"),
    BELGIUM("Belgium"),
    BELIZE("Belize"),
    BENIN("Benin"),
    BHUTAN("Bhutan"),
    BOLIVIA("Bolivia"),
    BOSNIA_HERZEGOVINA("Bosnia Herzegovina"),
    BOTSWANA("Botswana"),
    BRAZIL("Brazil"),
    BRUNEI("Brunei"),
    BULGARIA("Bulgaria"),
    BURKINA("Burkina"),
    BURMA("Burma"),
    BURUNDI("Burundi"),
    CAMBODIA("Cambodia"),
    CAMEROON("Cameroon"),
    CANADA("Canada"),
    CAPE_VERDE("Cape Verde"),
    CENTRAL_AFRICAN_REP("Central African Rep"),
    CHAD("Chad"),
    CHILE("Chile"),
    CHINA("Republic of China"),
    REPUBLIC_OF_CHINA("Republic of China"),
    COLOMBIA("Colombia"),
    COMOROS("Comoros"),
    DEMOCRATIC_REPUBLIC_OF_THE_CONGO("Democratic Republic of the Congo"),
    REPUBLIC_OF_THE_CONGO("Republic of the Congo"),
    COSTA_RICA("Costa Rica"),
    CROATIA("Croatia"),
    CUBA("Cuba"),
    CYPRUS("Cyprus"),
    CZECH_REPUBLIC("Czech Republic"),
    DANZIG("Danzig"),
    DENMARK("Denmark"),
    DJIBOUTI("Djibouti"),
    DOMINICA("Dominica"),
    DOMINICAN_REPUBLIC("Dominican Republic"),
    EAST_TIMOR("East Timor"),
    ECUADOR("Ecuador"),
    EGYPT("Egypt"),
    EL_SALVADOR("El Salvador"),
    EQUATORIAL_GUINEA("Equatorial Guinea"),
    ERITREA("Eritrea"),
    ESTONIA("Estonia"),
    ETHIOPIA("Ethiopia"),
    FIJI("Fiji"),
    FINLAND("Finland"),
    FRANCE("France"),
    GABON("Gabon"),
    GAZA_STRIP("Gaza Strip"),
    THE_GAMBIA("The Gambia"),
    GEORGIA("Georgia"),
    GERMANY("Germany"),
    GHANA("Ghana"),
    GREECE("Greece"),
    GRENADA("Grenada"),
    GUATEMALA("Guatemala"),
    GUINEA("Guinea"),
    GUINEA_BISSAU("Guinea-Bissau"),
    GUYANA("Guyana"),
    HAITI("Haiti"),
    HOLY_ROMAN_EMPIRE("Holy Roman Empire"),
    HONDURAS("Honduras"),
    HUNGARY("Hungary"),
    ICELAND("Iceland"),
    INDIA("India"),
    INDONESIA("Indonesia"),
    IRAN("Iran"),
    IRAQ("Iraq"),
    REPUBLIC_OF_IRELAND("Republic of Ireland"),
    ISRAEL("Israel"),
    ITALY("Italy"),
    IVORY_COAST("Ivory Coast"),
    JAMAICA("Jamaica"),
    JAPAN("Japan"),
    JONATHANLAND("Jonathanland"),
    JORDAN("Jordan"),
    KAZAKHSTAN("Kazakhstan"),
    KENYA("Kenya"),
    KIRIBATI("Kiribati"),
    NORTH_KOREA("North Korea"),
    SOUTH_KOREA("South Korea"),
    KOSOVO("Kosovo"),
    KUWAIT("Kuwait"),
    KYRGYZSTAN("Kyrgyzstan"),
    LAOS("Laos"),
    LATVIA("Latvia"),
    LEBANON("Lebanon"),
    LESOTHO("Lesotho"),
    LIBERIA("Liberia"),
    LIBYA("Libya"),
    LIECHTENSTEIN("Liechtenstein"),
    LITHUANIA("Lithuania"),
    LUXEMBOURG("Luxembourg"),
    MACEDONIA("Macedonia"),
    MADAGASCAR("Madagascar"),
    MALAWI("Malawi"),
    MALAYSIA("Malaysia"),
    MALDIVES("Maldives"),
    MALI("Mali"),
    MALTA("Malta"),
    MARSHALL_ISLANDS("Marshall Islands"),
    MAURITANIA("Mauritania"),
    MAURITIUS("Mauritius"),
    MEXICO("Mexico"),
    MICRONESIA("Micronesia"),
    MOLDOVA("Moldova"),
    MONACO("Monaco"),
    MONGOLIA("Mongolia"),
    MONTENEGRO("Montenegro"),
    MOROCCO("Morocco"),
    MOUNT_ATHOS("Mount Athos"),
    MOZAMBIQUE("Mozambique"),
    NAMIBIA("Namibia"),
    NAURU("Nauru"),
    NEPAL("Nepal"),
    NEWFOUNDLAND("Newfoundland"),
    NETHERLANDS("Netherlands"),
    NEW_ZEALAND("New Zealand"),
    NICARAGUA("Nicaragua"),
    NIGER("Niger"),
    NIGERIA("Nigeria"),
    NORWAY("Norway"),
    OMAN("Oman"),
    OTTOMAN_EMPIRE("Ottoman Empire"),
    PAKISTAN("Pakistan"),
    PALAU("Palau"),
    PANAMA("Panama"),
    PAPUA_NEW_GUINEA("Papua New Guinea"),
    PARAGUAY("Paraguay"),
    PERU("Peru"),
    PHILIPPINES("Philippines"),
    POLAND("Poland"),
    PORTUGAL("Portugal"),
    PRUSSIA("Prussia"),
    QATAR("Qatar"),
    ROMANIA("Romania"),
    ROME("Rome"),
    RUSSIAN_FEDERATION("Russian Federation"),
    RWANDA("Rwanda"),
    GRENADINES("Grenadines"),
    SAMOA("Samoa"),
    SAN_MARINO("San Marino"),
    SAO_TOME_PRINCIPE("Sao Tome & Principe"),
    SAUDI_ARABIA("Saudi Arabia"),
    SENEGAL("Senegal"),
    SERBIA("Serbia"),
    SEYCHELLES("Seychelles"),
    SIERRA_LEONE("Sierra Leone"),
    SINGAPORE("Singapore"),
    SLOVAKIA("Slovakia"),
    SLOVENIA("Slovenia"),
    SOLOMON_ISLANDS("Solomon Islands"),
    SOMALIA("Somalia"),
    SOUTH_AFRICA("South Africa"),
    SPAIN("Spain"),
    SRI_LANKA("Sri Lanka"),
    SUDAN("Sudan"),
    SURINAME("Suriname"),
    SWAZILAND("Swaziland"),
    SWEDEN("Sweden"),
    SWITZERLAND("Switzerland"),
    SYRIA("Syria"),
    TAJIKISTAN("Tajikistan"),
    TANZANIA("Tanzania"),
    THAILAND("Thailand"),
    TOGO("Togo"),
    TONGA("Tonga"),
    TRINIDAD_TOBAGO("Trinidad & Tobago"),
    TUNISIA("Tunisia"),
    TURKEY("Turkey"),
    TURKMENISTAN("Turkmenistan"),
    TUVALU("Tuvalu"),
    UGANDA("Uganda"),
    UKRAINE("Ukraine"),
    UNITED_ARAB_EMIRATES("United Arab Emirates"),
    UNITED_KINGDOM("United Kingdom"),
    URUGUAY("Uruguay"),
    UZBEKISTAN("Uzbekistan"),
    VANUATU("Vanuatu"),
    VATICAN_CITY("Vatican City"),
    VENEZUELA("Venezuela"),
    VIETNAM("Vietnam"),
    YEMEN("Yemen"),
    ZAMBIA("Zambia"),
    ZIMBABWE("Zimbabwe");

    private String country;

    Country(String country) {
        this.country = country;
    }

    public String getUrl() {
        return country;
    }

}
