SELECT
        w.fachrichtung
        , w.station
        , w.summe summe_fab
        , x.summe summe_station
        , (w.summe / x.summe) * 100 anteil_pct
  FROM
        ppr_wert w
        INNER JOIN (
            SELECT
                    station
                    , SUM(summe) summe
              FROM
                    ppr_wert w
             WHERE
                    station IN (1, 3, 9, 18, 40)
             GROUP BY
                    station
        ) x ON w.station = x.station
 ORDER BY
        w.fachrichtung
        , w.station
;
