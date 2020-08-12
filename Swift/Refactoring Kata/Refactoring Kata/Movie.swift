//
//  Movie.swift
//  Refactoring Kata
//
//  Created by Josep Rodriguez on 05/07/2019.
//  Copyright © 2019 Tigerspike. All rights reserved.
//

import Foundation

public enum PriceCode:Int {
    case regular = 0
    case newRelease = 1
    case childern = 2
}

public class Movie {

    public private(set) var title:String
    public var priceCode: PriceCode

    init(title:String, priceCode:PriceCode) {
        self.title = title
        self.priceCode = priceCode
    }
}
